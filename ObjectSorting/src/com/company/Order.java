package com.company;

import java.util.Comparator;

/**
 * Created by rgadbois on 9/15/16.
 */
public class Order implements Comparable<Order> {

    private int orderId;
    private int amount;
    private String customer;

    public static class OrderByAmount implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.amount > o2.amount ? 1 : o1.amount < o2.amount ? -1 : 0;
        }
    }

    public static class OrderByCustomer implements Comparator<Order> {

        @Override
        public int compare(Order o1, Order o2) {
            return o1.customer.compareTo(o2.customer);
        }
    }


    public Order(int orderId, int amount, String customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.customer = customer;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public int compareTo(Order o) {
        return this.orderId > o.orderId ? 1 : this.orderId < o.orderId ? -1 : 0;
    }
    @Override
    public String toString() {
        return String.valueOf(orderId);
    }


}
