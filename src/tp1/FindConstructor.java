package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import org.xml.sax.Attributes;

import health.AirConnectible;
import health.Alveoli;
import health.Artery;
import health.Atrium;
import health.BiDuct;
import health.Capillaries;
import health.Connectible;
import health.Connection;
import health.Connections;
import health.DeversingDuct;
import health.DigestiveTract;
import health.Duct;
import health.DuctOverflowableJunction;
import health.DuodenumTract;
import health.Flow;
import health.InnerGallbladder;
import health.MainBody;
import health.Nose;
import health.Organ;
import health.Organs;
import health.RectumTract;
import health.SalivaryDuct;
import health.StomachTract;
import health.Systems;
import health.System;
import health.To;
import health.Vein;
import health.Ventricle;

public class FindConstructor
{
    // Attributes
    private static MainBody mainBody;

    // Getters / Setters
    
    /**
     * @return the mainBody
     */
    public static MainBody getMainBody()
    {
        return mainBody;
    }

    /**
     * @param mainBody the mainBody to set
     */
    public static void setMainBody(MainBody mainBody)
    {
        FindConstructor.mainBody = mainBody;
    }

    // Methods
    
    /**
     * Find Constructor method
     * @param qName
     * @param attrs
     * @throws IFT287Exception
     */
    public void findConstructor(String qName, Attributes attrs) throws IFT287Exception
    {
        switch (qName)
        {
            case "MainBody":
                mainBody = new MainBody(attrs);
                break;
            case "Systems":
                mainBody.addSystems(new Systems());
                break;
            case "Organs":
                mainBody.addOrgans(new Organs());
                break;
            case "System":
                mainBody.addSystem(new System(attrs));
                break;
            case "Flow":
                mainBody.addFlow(new Flow(attrs));
                break;
            case "Connectible":
                mainBody.addConnectible(new Connectible(attrs));
                break;
            case "Connections":
                mainBody.addConnections(new Connections());
                break;
            case "Atrium":
                mainBody.addAtrium(new Atrium(attrs));
                break;
            case "Ventricle":
                new Ventricle(attrs);
                break;
            case "Artery":
                new Artery(attrs);
                break;
            case "Vein":
                new Vein(attrs);
                break;
            case "Capillaries":
                new Capillaries(attrs);
                break;
            case "Nose":
                new Nose(attrs);
                break;
            case "AirConnectible":
                new AirConnectible(attrs);
                break;
            case "Alveoli":
                new Alveoli(attrs);
                break;
            case "DigestiveTract":
                new DigestiveTract(attrs);
                break;
            case "StomachTract":
                mainBody.addStomachTract(new StomachTract(attrs));
                break;
            case "DuodenumTract":
                mainBody.addDuodenumTract(new DuodenumTract(attrs));
                break;
            case "RectumTract":
                mainBody.addRectumTract(new RectumTract(attrs));
                break;
            case "BiDuct":
                mainBody.addBiDuct(new BiDuct(attrs));
                break;
            case "Duct":
                mainBody.addDuct(new Duct(attrs));
                break;
            case "DuctOverflowableJunction":
                mainBody.addDuctOverflowableJunction(new DuctOverflowableJunction(attrs));
                break;
            case "DeversingDuct":
                mainBody.addDeversingDuct(new DeversingDuct(attrs));
                break;
            case "InnerGallbladder":
                mainBody.addInnerGallbladder(new InnerGallbladder(attrs));
                break;
            case "SalivaryDuct":
                mainBody.addSalivaryDuct(new SalivaryDuct(attrs));
                break;
            case "Connection":
                mainBody.addConnection(new Connection(attrs));
                break;
            case "to":
                mainBody.addTo(new To(attrs));
                break;
            case "Organ":
                mainBody.addOrgan(new Organ(attrs));
                break;
            default:
                throw new IFT287Exception("Error with the choice of the constructor");
        }
    }
}