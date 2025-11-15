package mafiagame.behavior;

/**
 * Something (or someone) that can participate in illegal activity,
 * such as a drug deal.
 */
public interface IllegalActivity {

    /**
     * Perform a drug deal between this participant and the partner.
     *
     * @param partner the other participant in the activity
     */
    void drugDealWith(IllegalActivity partner);
}
