package com.kixikila.service;

import com.kixikila.model.Participant;
import com.kixikila.model.Rosca;


public interface IRosca {

    int calculateMonthlyPayout(Rosca rosca, Participant participant);
    Participant getNextParticipant(Rosca rosca);
}
