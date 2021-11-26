package com.envyful.placeholders.simplevoterewards;

import com.envyful.papi.api.PlaceholderManager;
import com.envyful.simple.vote.rewards.forge.SimpleVoteRewardsForge;
import net.minecraft.entity.player.EntityPlayerMP;

public class SimpleVoteRewardsPlaceholders implements PlaceholderManager<EntityPlayerMP> {

    @Override
    public String getIdentifier() {
        return "simplevoterewards";
    }

    @Override
    public String[] getAuthors() {
        return new String[] { "Envyful" };
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public String onPlaceholderRequest(EntityPlayerMP player, String placeholder) {
        switch (placeholder.toLowerCase()) {
            case "vote_party":
                return (SimpleVoteRewardsForge.getInstance().getConfig().getVotePartyRequired()
                        - SimpleVoteRewardsForge.getInstance().getVoteCounter()) + "";
            case "vote_party_total" :
                return SimpleVoteRewardsForge.getInstance().getConfig().getVotePartyRequired() + "";
            case "votes" : return SimpleVoteRewardsForge.getInstance().getVoteCounter() + "";
        }

        return "UNDEFINED";
    }
}
