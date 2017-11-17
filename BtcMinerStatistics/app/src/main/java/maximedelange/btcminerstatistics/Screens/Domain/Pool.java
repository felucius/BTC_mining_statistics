package maximedelange.btcminerstatistics.Screens.Domain;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by M on 11/17/2017.
 */

public class Pool {
    // Fields
    private Double blocks = null;
    private Boolean mature = null;
    private Date dateFound = null;
    private Double hash = null;
    private Double confirmation = null;
    private Double totalShare = null;
    private Double totalScore = null;
    private Double reward = null;
    private Double miningDuration = null;
    private Date dateStarted = null;

    private HashMap<Integer, User> users;
    private HashMap<Integer, JSONParser> poolInformation;

    // Constructor
    public Pool(Double blocks, Boolean mature, Date dateFound, Double hash, Double confirmation, Double totalShare,
                Double totalScore, Double reward, Double miningDuration, Date dateStarted){
        this.blocks = blocks;
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
    public Double getBlocks(){return this.blocks;}

    public Boolean getMature(){return this.mature;}

    public Date getDateFound(){return this.dateFound;}

    public Double getHash(){return this.hash;}

    public Double getConfirmation(){return this.confirmation;}

    public Double getTotalShare(){return this.totalShare;}

    public Double getTotalScore(){return this.totalScore;}

    public Double getReward(){return this.reward;}

    public Double getMiningDuration(){return this.miningDuration;}

    public Date getDateStarted(){return this.dateStarted;}

    public HashMap<Integer, User> getUsers(){return this.users;}

    public HashMap<Integer, JSONParser> getPoolInformation(){return this.poolInformation;}
}
