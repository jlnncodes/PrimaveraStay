package primaverastay;

public class reservation {

    private int reservationId;
    private String guestName;
    private String contactNumber;
    private String unit;

    private String checkIn;
    private String checkInTime;
    private String checkOut;
    private String checkOutTime;

    private int numberOfGuests;
    private long numberOfNights;
    private double pricePerNight;
    private double totalAmount;
    private double amountPaid;
    private double balance;
    private String paymentStatus;
    private String reservationStatus;

    public reservation(
            int reservationId,
            String guestName,
            String contactNumber,
            String unit,
            String checkIn,
            String checkInTime,
            String checkOut,
            String checkOutTime,
            int numberOfGuests,
            long numberOfNights,
            double pricePerNight,
            double totalAmount,
            double amountPaid,
            double balance,
            String paymentStatus,
            String reservationStatus) {

        this.reservationId = reservationId;
        this.guestName = guestName;
        this.contactNumber = contactNumber;
        this.unit = unit;
        this.checkIn = checkIn;
        this.checkInTime = checkInTime;
        this.checkOut = checkOut;
        this.checkOutTime = checkOutTime;
        this.numberOfGuests = numberOfGuests;
        this.numberOfNights = numberOfNights;
        this.pricePerNight = pricePerNight;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
        this.balance = balance;
        this.paymentStatus = paymentStatus;
        this.reservationStatus = reservationStatus;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getUnit() {
        return unit;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public long getNumberOfNights() {
        return numberOfNights;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getBalance() {
        return balance;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setNumberOfNights(long numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}