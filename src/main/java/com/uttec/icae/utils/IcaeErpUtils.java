package com.uttec.icae.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

import com.icae.model.cfdi.v32.Comprobante;
import com.icae.model.nomina.v32.Nomina;
import com.uttec.icae.model.NominaPrefixMapper;

public class IcaeErpUtils {

	public static final String encodingUTF8 = "UTF-8";

	private static final Random RANDOM = new SecureRandom();
	
	private static final String CHARACTERS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
	
	public static String generateRandomPassword(int passwordLength) {
		StringBuilder passwordBuilder = new StringBuilder();
		for (int i = 0; i < passwordLength; i++) {
			int index = (int) (RANDOM.nextDouble() * CHARACTERS.length());
			passwordBuilder.append(CHARACTERS.charAt(index));
		}
		return passwordBuilder.toString();
	}
	
    public static void getXMLFactura(FileOutputStream fos, Comprobante comprobante) throws JAXBException, UnsupportedEncodingException, IOException {

        JAXBContext jaxb = JAXBContext.newInstance(Comprobante.class, Nomina.class);
        Marshaller marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NominaPrefixMapper());
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
//        marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.TRUE);
        marshaller.marshal(comprobante, new OutputStreamWriter(fos, "UTF-8"));
        fos.close();
    }
    
    public static void getXML(FileOutputStream fos, Comprobante comprobante) throws JAXBException, UnsupportedEncodingException {
        JAXBContext jaxb = JAXBContext.newInstance(Comprobante.class, Nomina.class);
        Marshaller marshaller = jaxb.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NominaPrefixMapper());
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd http://www.sat.gob.mx/nomina http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina11.xsd");
        marshaller.marshal(comprobante, new OutputStreamWriter(fos, "UTF-8"));
        try {
			fos.close();
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static byte[] getBytes(File file) 
    {
        try 
        {
            byte []buffer = new byte[1024];
            ByteArrayOutputStream ous = new ByteArrayOutputStream();
            InputStream ios = new FileInputStream(file);
              
            int read = 0;
            while ( (read = ios.read(buffer)) != -1 ) {
                ous.write(buffer, 0, read);
            }
            ios.close();
            ous.close();
            return ous.toByteArray();
        
        } 
        catch ( IOException e) 
        {
            e.printStackTrace();
            return null;
        }
        
    }

    public static void moveXML(String archivoIn)
    {
        SAXBuilder builder = new SAXBuilder();
        File archivoXML = new File(archivoIn);
        File archivoAcuseXML = new File(archivoIn.replace(".xml", "_acuse.xml"));
        String meses[]= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        try
        {
            Document documentoXML = (Document) builder.build( archivoXML );
            String strFecha = documentoXML.getRootElement().getAttributeValue("fecha");
            String path = DatatypeFactory.newInstance().newXMLGregorianCalendar(strFecha).getYear()+ "_" +meses[DatatypeFactory.newInstance().newXMLGregorianCalendar(strFecha).getMonth()-1];
            File directorio = new File(archivoXML.getAbsolutePath().replace(archivoXML.getName(),"") + "/" + path);
            System.out.println(directorio.getAbsolutePath());
            System.out.println(directorio.mkdirs());
            if(archivoXML.exists())
            {
                System.out.println(archivoXML.getAbsolutePath());
                archivoXML.renameTo(new File(directorio.getAbsolutePath()+"/"+archivoXML.getName()));
                System.out.println(new File(directorio.getAbsolutePath()+"/"+archivoXML.getName()));
            }
            if(archivoAcuseXML.exists())
            {
                System.out.println(archivoAcuseXML.getAbsolutePath());
                archivoAcuseXML.renameTo(new File(directorio.getAbsolutePath()+"/"+archivoAcuseXML.getName()));
                System.out.println(new File(directorio.getAbsolutePath()+"/"+archivoAcuseXML.getName()));
            }            
        }
        catch(Exception e)
        {
            e.printStackTrace();
           
        }
    }
    
	public static void generaXML(byte[] xml, String archivo) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(archivo));
			fos.write(xml);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
