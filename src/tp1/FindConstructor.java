package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

import org.xml.sax.Attributes;

import health.AirConnectible;
import health.Alveoli;
import health.Artery;
import health.Capillaries;
import health.Connectible;
import health.Connection;
import health.Connections;
import health.Flow;
import health.MainBody;
import health.Nose;
import health.Organ;
import health.Organs;
import health.SalivaryDuct;
import health.Systems;
import health.System;
import health.To;
import health.Vein;

public class FindConstructor
{
    // Comfort Constructor
    FindConstructor(String qName, Attributes attrs)
    {
        switch (qName)
        {
            case "MainBody":
                new MainBody(attrs);
                break;
            case "Systems":
                new Systems(attrs);
                break;
            case "Organs":
                new Organs(attrs);
                break;
            case "System":
                new System(attrs);
                break;
            case "Flow":
                new Flow(attrs);
                break;
            case "Connectible":
                new Connectible(attrs);
                break;
            case "Connections":
                new Connections(attrs);
                break;
            case "Atrium":
                new Atrium(attrs);
                break;
            case "Ventricule":
                new Ventricule(attrs);
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
                new StomachTract(attrs);
                break;
            case "DuodenumTract":
                new DuodenumTract(attrs);
                break;
            case "RectumTract":
                new RectumTract(attrs);
                break;
            case "BiDuct":
                new BiDuct(attrs);
                break;
            case "Duct":
                new Duct(attrs);
                break;
            case "DuctOverflowableJunction":
                new DuctOverflowableJunction(attrs);
                break;
            case "DeversingDuct":
                new DeversingDuct(attrs);
                break;
            case "InnerGallbladder":
                new InnerGallbladder(attrs);
                break;
            case "SalivaryDuct":
                new SalivaryDuct(attrs);
                break;
            case "Connection":
                new Connection(attrs);
                break;
            case "To":
                new To(attrs);
                break;
            case "Organ":
                new Organ(attrs);
                break;
            default:
                throw new IFT287Exception("Error with the choice of the constructor");
        }
    }
}