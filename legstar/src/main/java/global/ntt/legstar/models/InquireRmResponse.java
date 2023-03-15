package global.ntt.legstar.models;

import global.ntt.legstar.models.rm.output.RmmscsrlOut;
import global.ntt.legstar.models.rm.output.RmmscsrlOutRelCd;
import global.ntt.legstar.models.rm.output.RmmscsrlOutRelMast;
import global.ntt.legstar.models.rm.output.RmmscsrlOutRestOfRelKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InquireRmResponse implements Serializable {
    private String customerRmNumber;
    private String returnCode;
    private String returnMessage;
    private String entryCode;
    private String applicationCode;
    private String primaryRelationshipCode;
    private String secondaryRelationshipCode;
    private String accountControl1;
    private String accountControl2;
    private String accountControl3;
    private String accountControl4;
    private String accountNumber;

    public InquireRmResponse toInquireRmResponse(RmmscsrlOut rmmscsrlOut) {
        customerRmNumber = rmmscsrlOut.getRmmscsrlOutFromCustNbr();
        returnCode = rmmscsrlOut.getRmmscsrlOutReturnCode();
        returnMessage = rmmscsrlOut.getRmmscsrlOutReturnMsg();
        entryCode = Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutToEntCd).orElse(null);
        applicationCode = Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutToApplCd).orElse(null);
        primaryRelationshipCode = Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutRelCd).map(RmmscsrlOutRelCd::getRmmscsrlOutFromRelCd)
                .orElse(null);
        secondaryRelationshipCode = Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutRelCd).map(RmmscsrlOutRelCd::getRmmscsrlOutToRelCd)
                .orElse(null);
        accountControl1 =  Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutCustCtl1)
                .orElse(null);
        accountControl2 =  Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutCustCtl2)
                .orElse(null);
        accountControl3 =  Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutCustCtl3)
                .orElse(null);
        accountControl4 =  Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutCustCtl4)
                .orElse(null);
        accountNumber =  Optional.ofNullable(rmmscsrlOut.getRmmscsrlOutRelMast())
                .map(RmmscsrlOutRelMast::getRmmscsrlOutRestOfRelKey)
                .map(RmmscsrlOutRestOfRelKey::getRmmscsrlOutToAcctKey)
                .orElse(null);
        return this;
    }
}
