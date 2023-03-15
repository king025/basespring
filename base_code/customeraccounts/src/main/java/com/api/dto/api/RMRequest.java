package com.api.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record RMRequest(
        @Valid
        @NotNull
        @JsonProperty("rmacctno")
        RMAcctNo rmAcctNo) {

        public record RMAcctNo(

                @JsonProperty("rmCustomerCtrlNumber")
                @NotNull(message = "rmCustomerCtrlNumber is blank")
                RMCustomerCtrlNumber CustomerControlNumbers,
                @JsonProperty("rmNumber")
                @NotBlank(message = "rmNumber is blank")
                @Pattern(regexp="^[a-zA-Z0-9]{14}",message="max length is 14")
                String CustomerNumber,
                @Pattern(regexp="^[a-zA-Z]{0,55}",message="max length is 55")
                String nextItemKey){
        }

        public record RMCustomerCtrlNumber(
                @JsonProperty("rmCustomerCtrl1")
                @NotBlank(message = "rmCustomerCtrl1")
                @Pattern(regexp="^[a-zA-Z0-9]{4}",message="max length is 4")
                String CustomerControl1,
                @JsonProperty("rmCustomerCtrl2")
                @NotBlank(message = "rmCustomerCtrl2")
                @Pattern(regexp="^[a-zA-Z0-9]{4}",message="max length is 4")
                String CustomerControl2,
                @JsonProperty("rmCustomerCtrl3")
                @NotBlank(message = "rmCustomerCtrl3")
                @Pattern(regexp="^[a-zA-Z0-9]{4}",message="max length is 4")
                String CustomerControl3,
                @JsonProperty("rmCustomerCtrl4")
                @NotBlank(message = "rmCustomerCtrl4")
                @Pattern(regexp="^[a-zA-Z0-9]{4}",message="max length is 4")
                String CustomerControl4){
        }
}
