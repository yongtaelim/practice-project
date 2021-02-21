package com.example.practice.annotations;

public class StorePolicyFactory {
    public Policy getInstance(int type) {
        Policy policy = null;
        switch (type) {
            case 1:
                policy = new Store1Policy();
                break;
            case 2:
                policy = new Store2Policy();
                break;
            case 3:
                policy = new Store3Policy();
                break;
            default:
                policy = null;
        }
        return policy;
    }
}
