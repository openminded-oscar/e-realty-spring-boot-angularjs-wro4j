package com.mykosoft.realperfect.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "tbl_realty_object")
public class RealtyObject {
    private Long id;
    // +
    private Integer roomsAmount;
    // +
    private Integer floor;
    // +
    private Integer totalFloors;
    //+
    private BigDecimal price;
    // +
    private BigDecimal totalArea;
    // +
    private BigDecimal livingArea;
    // +
    private String description;
    // +
    private Boolean hasGarage;
    // +
    private Boolean hasRepairing;
    // +
    private Integer foundationYear;
    // +
    private String otherInfo;
    // +
    private BuildingType buildingType;
    // +
    private Set<OperationType> targetOperations;
    // +
    private Address address;
    // +
    private User owner;

    private Realter realter;
    private Boolean confirmed = false;
    private Boolean realterAware = false;
    private String mainPhotoPath;
    private String confirmationDocPhotoPath;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "rooms_amount")
    public Integer getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(Integer roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Column(name = "total_floors")
    public Integer getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(Integer totalFloors) {
        this.totalFloors = totalFloors;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "total_area")
    public BigDecimal getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(BigDecimal totalArea) {
        this.totalArea = totalArea;
    }

    @Column(name = "living_area")
    public BigDecimal getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(BigDecimal livingArea) {
        this.livingArea = livingArea;
    }

    @Column(name = "has_garage")
    public Boolean getHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(Boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    @Column(name = "has_repairing")
    public Boolean getHasRepairing() {
        return hasRepairing;
    }

    public void setHasRepairing(Boolean hasRepairing) {
        this.hasRepairing = hasRepairing;
    }

    @Column(name = "foundation_year")
    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "other_info")
    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Column(name = "building_type")
    @Enumerated(EnumType.STRING)
    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    @ElementCollection(targetClass = OperationType.class)
    @CollectionTable(name = "tbl_object_supported_operations",
            joinColumns = @JoinColumn(name = "object_id"))
    @Column(name = "operation_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public Set<OperationType> getTargetOperations() {
        return targetOperations;
    }

    public void setTargetOperations(Set<OperationType> targetOperations) {
        this.targetOperations = targetOperations;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Column(name = "realter_aware")
    public Boolean getRealterAware() {
        return realterAware;
    }

    public void setRealterAware(Boolean realterAware) {
        this.realterAware = realterAware;
    }

    @ManyToOne
    @JoinColumn(name = "realter_id", nullable = false)
    public Realter getRealter() {
        return realter;
    }

    public void setRealter(Realter realter) {
        this.realter = realter;
    }

    @Column(name = "main_photo_path")
    public String getMainPhotoPath() {
        return mainPhotoPath;
    }

    public void setMainPhotoPath(String mainPhotoPath) {
        this.mainPhotoPath = mainPhotoPath;
    }

    @Column(name = "confirmation_doc_photo_path")
    public String getConfirmationDocPhotoPath() {
        return confirmationDocPhotoPath;
    }

    public void setConfirmationDocPhotoPath(String confirmationDocPhotoPath) {
        this.confirmationDocPhotoPath = confirmationDocPhotoPath;
    }
}