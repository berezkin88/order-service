package com.example.orderservice.domain;

import javax.persistence.*;

@Entity
@AttributeOverride(
    name = "shippingAddress.address",
    column = @Column(name = "shipping_address")
)
@AttributeOverride(
    name = "shippingAddress.city",
    column = @Column(name = "shipping_city")
)
@AttributeOverride(
    name = "shippingAddress.state",
    column = @Column(name = "shipping_state")
)
@AttributeOverride(
    name = "shippingAddress.zipCode",
    column = @Column(name = "shipping_zip_code")
)
@AttributeOverride(
    name = "billToAddress.address",
    column = @Column(name = "bill_to_address")
)
@AttributeOverride(
    name = "billToAddress.city",
    column = @Column(name = "bill_to_city")
)
@AttributeOverride(
    name = "billToAddress.state",
    column = @Column(name = "bill_to_state")
)
@AttributeOverride(
    name = "billToAddress.zipCode",
    column = @Column(name = "bill_to_zip_code")
)
public class OrderHeader extends BaseEntity {

    private String customerName;
    @Embedded
    private Address shippingAddress;
    @Embedded
    private Address billToAddress;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillToAddress() {
        return billToAddress;
    }

    public void setBillToAddress(Address billToAddress) {
        this.billToAddress = billToAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderHeader that = (OrderHeader) o;

        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (shippingAddress != null ? !shippingAddress.equals(that.shippingAddress) : that.shippingAddress != null)
            return false;
        if (billToAddress != null ? !billToAddress.equals(that.billToAddress) : that.billToAddress != null)
            return false;
        return orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (billToAddress != null ? billToAddress.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }
}
