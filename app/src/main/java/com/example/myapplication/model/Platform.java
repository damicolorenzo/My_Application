package com.example.myapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONObject;

import java.io.Serializable;

@Entity(tableName = "platforms")
public class Platform implements Serializable {
    public static Platform parseJSon(JSONObject object) {
        if (object == null)
            return null;

        Platform p = new Platform();
        p.setDenominazione(object.optString("cdeenominazione"));
        p.setStato(object.optString("cstato"));
        p.setAnnoCostruzione(object.optString("canno_costruzione"));


        try {
            String valueLng = object.optString("clongitudine", null);
            if (valueLng != null) {
                p.setLongitudine(Double.parseDouble(valueLng));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            String valueLat = object.optString("clatitudine", null);
            if (valueLat != null) {
                p.setLatitudine(Double.parseDouble(valueLat));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return p;
    }
    @PrimaryKey
    private int id;
    private String denominazione, stato, anno_costruzione, tipo, minerale, operatore;
    private double longitudine, latitudine;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDenominazione() {
        return this.denominazione;
    }
    public void setDenominazione(String den) {
        this.denominazione = den;
    }
    public double getLatitudine() {
        return latitudine;
    }
    private void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }
    public double getLongitudine() {
        return longitudine;
    }
    private void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public String getAnnoCostruzione() {
        return this.anno_costruzione;
    }
    private void setAnnoCostruzione(String annoCostruzione) {
        this.anno_costruzione = annoCostruzione;
    }
    public String getStato() {
        return this.stato;
    }
    private void setStato(String stato) {
        this.stato = stato;
    }

}


/*
{
"cdenominazione__":"ADA 2",
"ccodice":"290",
"cstato":"Non Operativa",
"canno_costruzione":"1982|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/ganno.asp?anno=1982",
"ctipo":"monotubolare|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/gtipo.asp?tipo=monotubolare",
"cminerale":"GAS",
"coperatore":"ENI|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/goperatore.asp?operatore=ENI",
"cnumero_pozzi_allacciati__":"1",
"cpozzi_produttivi_non_eroganti":"1",
"cpozzi_in_produzione":"",
"cpozzi_in_monitoraggio":"",
"ctitolo_minerario":"A.C 9.AG|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/gtitolo.asp?titolo=A.C%20%209.AG",
"ccollegata_alla_centrale":"",
"czona":"ZA|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/gzona.asp?zona=ZA",
"cfoglio":"924/M",
"csezione_unmig":"Bologna|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/gsezione.asp?sezione=BO&sez=Bologna",
"ccapitaneria_di_porto":"Ravenna|http://unmig.sviluppoeconomico.gov.it/unmig/strutturemarine/gcapitaneria.asp?capitaneria=Ravenna",
"cdistanza_costa___km_":"20",
"caltezza_slm__m_":"15",
"cprofondit__fondale__m_":"25",
"cdimensioni":"8 x 8 m",
"clongitudine__wgs_84__":"12.591285",
"clatitudine__wgs84__":"45.183634"
}
 */