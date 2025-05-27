package com.psp.fd.pspspringboot.dto;

public class ListUserRequest {

    private Integer agentId;

    private String receiverName;

    private String bankName;

    private String isNewBlackList;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getNewBlackList() {
        return isNewBlackList;
    }

    public String setNewBlackList(String newBlackList) {
        return newBlackList;
    }
}
