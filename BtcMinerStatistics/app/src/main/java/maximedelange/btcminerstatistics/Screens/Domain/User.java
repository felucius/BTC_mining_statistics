package maximedelange.btcminerstatistics.Screens.Domain;

/**
 * Created by M on 11/17/2017.
 */

public class User {
    // Fields
    private String username = null;
    private String rating = null;
    private Double unconfirmedReward = null;
    private Double estimatedReward = null;
    private Double hashRate = null;
    private Double confirmedReward = null;
    private Double sendThreshold = null;
    private Integer worker = null;
    private Double lastShare = null;
    private Double score = null;
    private Boolean alive = null;
    private Double wallet = null;

    private Pool pool;

    // Constructor
    public User(String username, String rating, Double unconfirmedReward, Double estimatedReward, Double hashRate,
                Double confirmedReward, Double sendThreshold, Integer worker, Double lastShare, Double score, Boolean alive, Double wallet){
        this.username = username;
        this.rating = rating;
        this.unconfirmedReward = unconfirmedReward;
        this.estimatedReward = estimatedReward;
        this.hashRate = hashRate;
        this.confirmedReward = confirmedReward;
        this.sendThreshold = sendThreshold;
        this.worker = worker;
        this.lastShare = lastShare;
        this.score = score;
        this.alive = alive;
        this.wallet = wallet;
    }

    // Methods
    public String getUsername(){
        return this.username;
    }

    public String getRating(){
        return this.rating;
    }

    public Double getUnconfirmedReward(){
        return this.unconfirmedReward;
    }

    public Double getEstimatedReward(){
        return this.estimatedReward;
    }

    public Double getHashRate(){
        return this.hashRate;
    }

    public Double getConfirmedReward(){
        return this.confirmedReward;
    }

    public Double getSendThreshold(){
        return this.sendThreshold;
    }

    public Integer getWorker(){
        return this.worker;
    }

    public Double getLastShare(){
        return this.lastShare;
    }

    public Double getScore(){
        return this.score;
    }

    public Boolean getAlive(){
        return this.alive;
    }

    public Double getWallet(){
        return this.wallet;
    }
}
