package tp1;

// Travail fait par :
// Bobet Pierrick - 17 131 792
// Bouteloup Remy - 17 132 265

/**
 * L'exception IFT287Exception est levee lorsqu'une transaction est inadequate.
 */
public final class IFT287Exception extends Exception
{
    // Attribut
    private static final long serialVersionUID = 1L;

    /**
     * Méthode appelée lorsqu'une exception est levée
     * 
     * @param message
     */
    public IFT287Exception(String message)
    {
        super(message);
    }
}