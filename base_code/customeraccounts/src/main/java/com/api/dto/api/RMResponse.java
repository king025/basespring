package com.api.dto.api;

import java.util.List;

public record RMResponse(String rmNumber, String nextItemFlag, String nextItemKey, String returnCode,
                         String returnMessage, List<RMLinkedAccount> rmLinkedAccount) {

    public record RMLinkedAccount(AdditionalRelInfo additionalRelInfo, RMRelKey rmRelKey) {
    }

    public record RMRelKey(String customerToAcc, String appCode, RelCode relCode, String customerAcctCtl1,
                           String customerAcctCtl2, String customerAcctCtl3, String customerAcctCtl4,
                           String customerAcctNumber) {
    }

    public record RelCode(String relCodeFrom, String relCodeTo) {
    }

    public record AdditionalRelInfo(String appId, String legalTitle, InternetBankInfo internetBankInfo) {
    }

    public record InternetBankInfo(String acctTag, String billsPayTag, String fromFundTransTag, String toFundTransTag,
                                   String ibDownloadTag) {
    }

}
