package com.envyful.placeholders.reforged.extension.party.impl;

import com.envyful.placeholders.reforged.extension.party.PartyReforgedExtension;
import com.google.common.collect.Lists;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraft.entity.player.ServerPlayerEntity;

import java.util.List;

public class PartyMoveTwoExtension extends PartyReforgedExtension {

    private static final String NAME = "moveset_2";
    private static final int PRIORITY = 1;
    private static final List<String> DESCRIPTION = Lists.newArrayList("Gets the pokemon's move 2 in the given slot");
    private static final List<String> EXAMPLES = Lists.newArrayList("%reforged_party_slot_1_moveset_2%");

    public PartyMoveTwoExtension() {
        super(NAME, PRIORITY, DESCRIPTION, EXAMPLES);
    }

    @Override
    protected String parse(ServerPlayerEntity player, String placeholder, Pokemon pokemon) {
        if (pokemon == null || pokemon.getMoveset().isEmpty() || pokemon.getMoveset().attacks[1] == null) {
            return "N/A";
        }

        return pokemon.getMoveset().attacks[1].getMove().getAttackName() + "";
    }
}
