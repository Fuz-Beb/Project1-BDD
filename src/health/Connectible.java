package health;

import java.util.HashMap;

import org.xml.sax.Attributes;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

public class Connectible
{
    // Attributes
    private HashMap<Integer, Atrium> atriumTab;
    private HashMap<Integer, Ventricle> ventricleTab;
    private HashMap<Integer, Artery> arteryTab;
    private HashMap<Integer, Vein> veinTab;
    private HashMap<Integer, Capillaries> capillariesTab;
    private HashMap<Integer, Nose> noseTab;
    private HashMap<Integer, AirConnectible> airConnectibleTab;
    private HashMap<Integer, Alveoli> alveoliTab;
    private HashMap<Integer, DigestiveTract> digestiveTractTab;
    private HashMap<Integer, StomachTract> stomachTractTab;
    private HashMap<Integer, DuodenumTract> duodenumTractTab;
    private HashMap<Integer, RectumTract> rectumTractTab;
    private HashMap<Integer, BiDuct> biductTab;
    private HashMap<Integer, Duct> ductTab;
    private HashMap<Integer, DuctOverflowableJunction> ductOverflowableJunctionTab;
    private HashMap<Integer, DeversingDuct> deversingDuctTab;
    private HashMap<Integer, InnerGallbladder> innerGallbladderTab;
    private HashMap<Integer, SalivaryDuct> salivaryDuctTab;

    // Comfort Constructor
    public Connectible(Attributes attrs)
    {
        atriumTab = new HashMap<Integer, Atrium>();
        ventricleTab = new HashMap<Integer, Ventricle>();
        arteryTab = new HashMap<Integer, Artery>();
        veinTab = new HashMap<Integer, Vein>();
        capillariesTab = new HashMap<Integer, Capillaries>();
        noseTab = new HashMap<Integer, Nose>();
        airConnectibleTab = new HashMap<Integer, AirConnectible>();
        alveoliTab = new HashMap<Integer, Alveoli>();
        digestiveTractTab = new HashMap<Integer, DigestiveTract>();
        stomachTractTab = new HashMap<Integer, StomachTract>();
        duodenumTractTab = new HashMap<Integer, DuodenumTract>();
        rectumTractTab = new HashMap<Integer, RectumTract>();
        biductTab = new HashMap<Integer, BiDuct>();
        ductTab = new HashMap<Integer, Duct>();
        ductOverflowableJunctionTab = new HashMap<Integer, DuctOverflowableJunction>();
        deversingDuctTab = new HashMap<Integer, DeversingDuct>();
        innerGallbladderTab = new HashMap<Integer, InnerGallbladder>();
        salivaryDuctTab = new HashMap<Integer, SalivaryDuct>();
    }

    /**
     * @return the atriumTab
     */
    public HashMap<Integer, Atrium> getAtriumTab()
    {
        return atriumTab;
    }

    /**
     * @param atriumTab
     *            the atriumTab to set
     */
    public void setAtriumTab(HashMap<Integer, Atrium> atriumTab)
    {
        this.atriumTab = atriumTab;
    }

    /**
     * @return the ventricleTab
     */
    public HashMap<Integer, Ventricle> getVentricleTab()
    {
        return ventricleTab;
    }

    /**
     * @param ventricleTab
     *            the ventricleTab to set
     */
    public void setVentricleTab(HashMap<Integer, Ventricle> ventricleTab)
    {
        this.ventricleTab = ventricleTab;
    }

    /**
     * @return the arteryTab
     */
    public HashMap<Integer, Artery> getArteryTab()
    {
        return arteryTab;
    }

    /**
     * @param arteryTab
     *            the arteryTab to set
     */
    public void setArteryTab(HashMap<Integer, Artery> arteryTab)
    {
        this.arteryTab = arteryTab;
    }

    /**
     * @return the veinTab
     */
    public HashMap<Integer, Vein> getVeinTab()
    {
        return veinTab;
    }

    /**
     * @param veinTab
     *            the veinTab to set
     */
    public void setVeinTab(HashMap<Integer, Vein> veinTab)
    {
        this.veinTab = veinTab;
    }

    /**
     * @return the capillariesTab
     */
    public HashMap<Integer, Capillaries> getCapillariesTab()
    {
        return capillariesTab;
    }

    /**
     * @param capillariesTab
     *            the capillariesTab to set
     */
    public void setCapillariesTab(HashMap<Integer, Capillaries> capillariesTab)
    {
        this.capillariesTab = capillariesTab;
    }

    /**
     * @return the noseTab
     */
    public HashMap<Integer, Nose> getNoseTab()
    {
        return noseTab;
    }

    /**
     * @param noseTab
     *            the noseTab to set
     */
    public void setNoseTab(HashMap<Integer, Nose> noseTab)
    {
        this.noseTab = noseTab;
    }

    /**
     * @return the airConnectibleTab
     */
    public HashMap<Integer, AirConnectible> getAirConnectibleTab()
    {
        return airConnectibleTab;
    }

    /**
     * @param airConnectibleTab
     *            the airConnectibleTab to set
     */
    public void setAirConnectibleTab(HashMap<Integer, AirConnectible> airConnectibleTab)
    {
        this.airConnectibleTab = airConnectibleTab;
    }

    /**
     * @return the alveoliTab
     */
    public HashMap<Integer, Alveoli> getAlveoliTab()
    {
        return alveoliTab;
    }

    /**
     * @param alveoliTab
     *            the alveoliTab to set
     */
    public void setAlveoliTab(HashMap<Integer, Alveoli> alveoliTab)
    {
        this.alveoliTab = alveoliTab;
    }

    /**
     * @return the digestiveTractTab
     */
    public HashMap<Integer, DigestiveTract> getDigestiveTractTab()
    {
        return digestiveTractTab;
    }

    /**
     * @param digestiveTractTab
     *            the digestiveTractTab to set
     */
    public void setDigestiveTractTab(HashMap<Integer, DigestiveTract> digestiveTractTab)
    {
        this.digestiveTractTab = digestiveTractTab;
    }

    /**
     * @return the stomachTractTab
     */
    public HashMap<Integer, StomachTract> getStomachTractTab()
    {
        return stomachTractTab;
    }

    /**
     * @param stomachTractTab
     *            the stomachTractTab to set
     */
    public void setStomachTractTab(HashMap<Integer, StomachTract> stomachTractTab)
    {
        this.stomachTractTab = stomachTractTab;
    }

    /**
     * @return the duodenumTractTab
     */
    public HashMap<Integer, DuodenumTract> getDuodenumTractTab()
    {
        return duodenumTractTab;
    }

    /**
     * @param duodenumTractTab
     *            the duodenumTractTab to set
     */
    public void setDuodenumTractTab(HashMap<Integer, DuodenumTract> duodenumTractTab)
    {
        this.duodenumTractTab = duodenumTractTab;
    }

    /**
     * @return the rectumTractTab
     */
    public HashMap<Integer, RectumTract> getRectumTractTab()
    {
        return rectumTractTab;
    }

    /**
     * @param rectumTractTab
     *            the rectumTractTab to set
     */
    public void setRectumTractTab(HashMap<Integer, RectumTract> rectumTractTab)
    {
        this.rectumTractTab = rectumTractTab;
    }

    /**
     * @return the biductTab
     */
    public HashMap<Integer, BiDuct> getBiductTab()
    {
        return biductTab;
    }

    /**
     * @param biductTab
     *            the biductTab to set
     */
    public void setBiductTab(HashMap<Integer, BiDuct> biductTab)
    {
        this.biductTab = biductTab;
    }

    /**
     * @return the ductTab
     */
    public HashMap<Integer, Duct> getDuctTab()
    {
        return ductTab;
    }

    /**
     * @param ductTab
     *            the ductTab to set
     */
    public void setDuctTab(HashMap<Integer, Duct> ductTab)
    {
        this.ductTab = ductTab;
    }

    /**
     * @return the ductOverflowableJunctionTab
     */
    public HashMap<Integer, DuctOverflowableJunction> getDuctOverflowableJunctionTab()
    {
        return ductOverflowableJunctionTab;
    }

    /**
     * @param ductOverflowableJunctionTab
     *            the ductOverflowableJunctionTab to set
     */
    public void setDuctOverflowableJunctionTab(HashMap<Integer, DuctOverflowableJunction> ductOverflowableJunctionTab)
    {
        this.ductOverflowableJunctionTab = ductOverflowableJunctionTab;
    }

    /**
     * @return the deversingDuctTab
     */
    public HashMap<Integer, DeversingDuct> getDeversingDuctTab()
    {
        return deversingDuctTab;
    }

    /**
     * @param deversingDuctTab
     *            the deversingDuctTab to set
     */
    public void setDeversingDuctTab(HashMap<Integer, DeversingDuct> deversingDuctTab)
    {
        this.deversingDuctTab = deversingDuctTab;
    }

    /**
     * @return the innerGallbladderTab
     */
    public HashMap<Integer, InnerGallbladder> getInnerGallbladderTab()
    {
        return innerGallbladderTab;
    }

    /**
     * @param innerGallbladderTab
     *            the innerGallbladderTab to set
     */
    public void setInnerGallbladderTab(HashMap<Integer, InnerGallbladder> innerGallbladderTab)
    {
        this.innerGallbladderTab = innerGallbladderTab;
    }

    /**
     * @return the salivaryDuctTab
     */
    public HashMap<Integer, SalivaryDuct> getSalivaryDuctTab()
    {
        return salivaryDuctTab;
    }

    /**
     * @param salivaryDuctTab
     *            the salivaryDuctTab to set
     */
    public void setSalivaryDuctTab(HashMap<Integer, SalivaryDuct> salivaryDuctTab)
    {
        this.salivaryDuctTab = salivaryDuctTab;
    }

    // Methods
    public void addAtrium(Atrium atrium)
    {
        atriumTab.put(atriumTab.size(), atrium);
    }
    
    public void addVentricle(Ventricle ventricle)
    {
        ventricleTab.put(ventricleTab.size(), ventricle);
    }
    
    public void addArtery(Artery artery)
    {
        arteryTab.put(arteryTab.size(), artery);
    }
    
    public void addVein(Vein vein)
    {
        veinTab.put(veinTab.size(), vein);
    }
    
    public void addCapillaries(Capillaries capillaries)
    {
        capillariesTab.put(capillariesTab.size(), capillaries);
    }
    
    public void addNose(Nose nose)
    {
        noseTab.put(noseTab.size(), nose);
    }
    
    public void addAirConnectible(AirConnectible airConnectible)
    {
        airConnectibleTab.put(airConnectibleTab.size(), airConnectible);
    }
    
    public void addAlveoli(Alveoli alveoli)
    {
        alveoliTab.put(alveoliTab.size(), alveoli);
    }
    
    public void addDigestiveTract(DigestiveTract digestiveTract)
    {
        digestiveTractTab.put(digestiveTractTab.size(), digestiveTract);
    }
    
    public void addStomachTract(StomachTract stomachTract)
    {
        stomachTractTab.put(stomachTractTab.size(), stomachTract);
    }

    public void addDuodenumTract(DuodenumTract duodenumTract)
    {
        duodenumTractTab.put(duodenumTractTab.size(), duodenumTract);
    }

    public void addRectumTract(RectumTract rectumTract)
    {
        rectumTractTab.put(rectumTractTab.size(), rectumTract);
    }
}