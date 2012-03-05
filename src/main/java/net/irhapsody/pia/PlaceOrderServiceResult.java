package net.irhapsody.pia;


public class PlaceOrderServiceResult {

    private boolean status;
    private PendingOrder pendingOrder;

    public PlaceOrderServiceResult(boolean status, PendingOrder pendingOrder) {
        this.status = status;
        this.pendingOrder = pendingOrder;
    }

    public PendingOrder getPendingOrder() {
        return pendingOrder;  //To change body of created methods use File | Settings | File Templates.
    }

    public boolean isSuccess() {
        return status;
    }
}
