package com.nur.factories.commends;


import com.nur.core.BusinessRuleValidationException;
import com.nur.model.Commend;

import java.util.UUID;

public interface ICommendFactory {
    Commend saveCommend(UUID userId, String comment, String valoration, String ownProperty, int points) throws BusinessRuleValidationException;
}
