package maximedelange.btcminerstatistics.Screens.Domain;

import java.util.HashMap;

/**
 * Created by M on 11/19/2017.
 */

public class BlockNumber extends Pool {
    // Fields
    private Boolean mature = null;
    private String dateFound = null;
    private String hash = null;
    private Double confirmation = null;
    private Double totalShare = null;
    private Double totalScore = null;
    private Double reward = null;
    private Double miningDuration = null;
    private String dateStarted = null;

    private HashMap<Integer, User> users;
    private HashMap<Integer, JSONParser> poolInformation;

    public BlockNumber(Boolean mature, String dateFound, String hash, Double confirmation, Double totalShare,
                       Double totalScore, Double reward, Double miningDuration, String dateStarted){
        this.mature = mature;
        this.dateFound = dateFound;
        this.hash = hash;
        this.confirmation = confirmation;
        this.totalShare = totalShare;
        this.totalScore = totalScore;
        this.reward = reward;
        this.miningDuration = miningDuration;
        this.dateStarted = dateStarted;
    }

    // Methods
    public Boolean getMature(){return this.mature;}

    public String getDateFound(){return this.dateFound;}

    public String getHash(){return this.hash;}

    public Double getConfirmation(){return this.confirmation;}

    public Double getTotalShare(){return this.totalShare;}

    public Double getTotalScore(){return this.totalScore;}

    public Double getReward(){return this.reward;}

    public Double getMiningDuration(){return this.miningDuration;}

    public String getDateStarted(){return this.dateStarted;}

    public HashMap<Integer, User> getUsers(){return this.users;}

    public HashMap<Integer, JSONParser> getPoolInformation(){return this.poolInformation;}
}
