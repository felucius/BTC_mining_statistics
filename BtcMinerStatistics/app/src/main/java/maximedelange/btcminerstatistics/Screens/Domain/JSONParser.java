package maximedelange.btcminerstatistics.Screens.Domain;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by M on 11/17/2017.
 */

public class JSONParser {
    // Fields
    private User user = null;
    private Pool pool = null;
    private BlockNumber blockNumber = null;
    private HashMap<Integer, User> users = null;
    private HashMap<Integer, HashMap<Integer, BlockNumber>> pools = null;
    private HashMap<Integer, BlockNumber> blockNumbers = null;

    private HashMap<Integer, APICall> apiCalls = null;
    private APICall apicall = null;

    // Constructor
    public JSONParser(){
        pool = new Pool();
        pools = new HashMap<>();
        blockNumbers = new HashMap<>();
    }

    // Methods
    public User parseUserInformation(){
        apicall = new APICall();
        String userInformation = apicall.getUserInformation("https://slushpool.com/accounts/profile/json/1685801-8b72ca0d0e6857fe67e61f50883ffe14");

        try {
            JSONObject account = new JSONObject(userInformation);

            String usernameAccount = account.getString("username");
            String unconfirmedAccount = account.getString("unconfirmed_reward");
            String ratingAccount = account.getString("rating");
            String sendThresholdNMCAccount = account.getString("nmc_send_threshold");
            String unconfirmedNMCAccount = account.getString("unconfirmed_nmc_reward");
            String estimatedAccount = account.getString("estimated_reward");
            String hashrateAccount = account.getString("hashrate");
            String confirmedNCMAccount = account.getString("confirmed_nmc_reward");
            String sendThresholdAccount = account.getString("send_threshold");
            String confirmedAccount = account.getString("confirmed_reward");

            JSONObject workerObject = account.getJSONObject("workers");
            JSONObject workerPayoutObject = workerObject.getJSONObject("felucius.bitminerrasppie");
            String lastShareWorker = workerPayoutObject.getString("last_share");
            String scoreWorker = workerPayoutObject.getString("score");
            String aliveWorker = workerPayoutObject.getString("alive");
            String shareWorker = workerPayoutObject.getString("shares");
            String hashrateWorker = workerPayoutObject.getString("hashrate");

            String walletObject = account.getString("wallet");

            Double unconfirmedReward = Double.valueOf(unconfirmedAccount);
            Double estimatedReward = Double.valueOf(estimatedAccount);
            Double hashrate = Double.valueOf(hashrateAccount);
            Double confirmedReward = Double.valueOf(confirmedAccount);
            Double sendThreshold = Double.valueOf(sendThresholdAccount);
            Integer worker = 1;
            Double lastShare = Double.valueOf(lastShareWorker);
            Double score = Double.valueOf(scoreWorker);
            Boolean alive = Boolean.valueOf(aliveWorker);
            String wallet = String.valueOf(walletObject);

            this.user = new User(usernameAccount, ratingAccount, unconfirmedReward, estimatedReward, hashrate, confirmedReward,
                    sendThreshold, worker, lastShare, score, alive, wallet);
            //users.put(1, user);


        }catch (JSONException jsonEx){
            jsonEx.getLocalizedMessage();

        }


        return user;
    }

    public HashMap<Integer, HashMap<Integer, BlockNumber>> parsePoolInformation(){
        apicall = new APICall();
        String poolInformation = apicall.getPoolInformation("https://slushpool.com/stats/json/1685801-8b72ca0d0e6857fe67e61f50883ffe14");
        Integer id = 0;

        try {
            JSONObject poolObject = new JSONObject(poolInformation);

            JSONObject block = poolObject.getJSONObject("blocks");

            for(int i = 0; i < poolObject.length(); i++){
                JSONObject blockNR = block.getJSONObject("495296");

                String maturePool = blockNR.getString("is_mature");
                String dateFoundPool = blockNR.getString("date_found");
                String hashPool = blockNR.getString("hash");
                String confirmationPool = blockNR.getString("confirmations");
                String totalSharePool = blockNR.getString("total_shares");
                String totalScorePool = blockNR.getString("total_score");
                String rewardPool = blockNR.getString("reward");
                String miningDurationPool = blockNR.getString("mining_duration");
                String dateStartedPool = blockNR.getString("date_started");
                String rewardNMCPool = blockNR.getString("nmc_reward");

                //Double blockNr = Double.valueOf(blockNR.getDouble("495011"));
                Boolean mature = Boolean.valueOf(maturePool);
                String dateFound = String.valueOf(dateFoundPool);
                String hash = String.valueOf(hashPool);
                Double confirmation = Double.valueOf(confirmationPool);
                Double totalShare = Double.valueOf(totalSharePool);
                Double totalScore = Double.valueOf(totalScorePool);
                Double reward = Double.valueOf(rewardPool);
                Double miningDuration = Double.valueOf(miningDurationPool);
                String dateStarted = String.valueOf(dateStartedPool);

                this.blockNumber = new BlockNumber(i, mature, dateFound, hash, confirmation, totalShare, totalScore, reward,
                        miningDuration, dateStarted);

                blockNumbers.put(i, blockNumber);
                pools.put(1, blockNumbers);
            }


        }catch (JSONException jsonEx){
            jsonEx.getLocalizedMessage();
        }

        return pools;
    }

    public HashMap<Integer, APICall> getAPICalls(){return this.apiCalls;}
}
