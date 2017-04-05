/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uttec.icae.model;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class NominaPrefixMapper extends NamespacePrefixMapper {
 
    public enum Prefijos 
    {

        CFDI("cfdi","http://www.sat.gob.mx/cfd/3"),
        TFD("tfd","http://www.sat.gob.mx/TimbreFiscalDigital"),
        XSI("xsi","http://www.w3.org/2001/XMLSchema-instance"),
        NOMIMA("nomina","http://www.sat.gob.mx/nomina");
        private String prefijo;
        private String URI;

        private Prefijos(String prefijo,String URI)
        {
           this.prefijo = prefijo;
           this.URI = URI;
        }

        /**
         * @return the nombre
         */
        public String getPrefijo() {
            return prefijo;
        }  

        public String getURI()
        {
            return URI;
        }
    }
 
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        
        Prefijos prefijo=null;
        for(Prefijos prefijoAux : Prefijos.values())
        {
            if(prefijoAux.getURI().equals(namespaceUri))
            {
                prefijo=prefijoAux;
                break;
            }
        }
        switch(prefijo) 
        {
            case CFDI:
                return Prefijos.CFDI.getPrefijo();
            case TFD:
                return Prefijos.TFD.getPrefijo();
            case XSI:
                return Prefijos.XSI.getPrefijo();
            case NOMIMA:
                return Prefijos.NOMIMA.getPrefijo();
        }
        return suggestion;
    }
 
    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] {Prefijos.CFDI.getURI(),Prefijos.TFD.getURI(),Prefijos.XSI.getURI(),Prefijos.NOMIMA.getURI()};
    }
    
    
 
}