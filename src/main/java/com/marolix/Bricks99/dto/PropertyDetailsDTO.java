package com.marolix.Bricks99.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.marolix.Bricks99.entity.PropertyAddress;
import com.marolix.Bricks99.entity.PropertyDetails;
import com.marolix.Bricks99.entity.SellerRegistration;

public class PropertyDetailsDTO {
	private Integer propertyId;
	@NotNull(message = "{property.address.propertyName.empty}")
	@Pattern(regexp = "^[A-Za-z0-9/.,-]+$", message = "{property.address.propertyName.invalid}")
	private String propertyName;
	@NotNull(message = "{property.address.propertyType.empty}")
	@Pattern(regexp = "^[A-Za-z0-9/.,-]+$", message = "{property.address.propertyType.invalid}")
	private String propertyType;
	@NotNull(message = "{property.address.propertyPrice.empty}")
	@Pattern(regexp = "^[0-9]+(\\.[0-9]{1,3})?$", message = "{property.address.propertyPrice.invalid}")
	private Double propertyPrice;
	@NotNull(message = "{property.address.numberOfRooms.empty}")
	@Pattern(regexp = "^[1-9][0-9]*[a-zA-Z]*$", message = "{property.address.numberOfRooms.invalid}")
	private String numberOfRooms;
	private Double areaInSqft;

	private String category;
	private Integer bathRooms;
	private Integer bedRooms;
	private Integer noOfPhotosUploaded;
	private String[] imageNames;

	public Integer getNoOfPhotosUploaded() {
		return noOfPhotosUploaded;
	}

	public void setNoOfPhotosUploaded(Integer noOfPhotosUploaded) {
		this.noOfPhotosUploaded = noOfPhotosUploaded;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getBathRooms() {
		return bathRooms;
	}

	public void setBathRooms(Integer bathRooms) {
		this.bathRooms = bathRooms;
	}

	public Integer getBedRooms() {
		return bedRooms;
	}

	public void setBedRooms(Integer bedRooms) {
		this.bedRooms = bedRooms;
	}

	public Integer getBuildingAge() {
		return buildingAge;
	}

	public void setBuildingAge(Integer buildingAge) {
		this.buildingAge = buildingAge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Integer buildingAge;
	private String description;

	public Double getAreaInSqft() {
		return areaInSqft;
	}

	public void setAreaInSqft(Double areaInSqft) {
		this.areaInSqft = areaInSqft;
	}

	private PropertyAddressDTO propertyAddress;
	@NotNull
	private Integer sellerId;

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public void setPropertyPrice(Double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public PropertyDetailsDTO() {
	}

	public PropertyDetailsDTO(Integer propertyId, String propertyName, String propertyType, Double propertyPrice,
			String numberOfRooms, PropertyAddressDTO propertyAddress) {
		super();
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyType = propertyType;
		this.propertyPrice = propertyPrice;
		this.numberOfRooms = numberOfRooms;
		this.propertyAddress = propertyAddress;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public double getPropertyPrice() {
		return propertyPrice;
	}

	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public PropertyAddressDTO getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(PropertyAddressDTO propertyAddressDto) {
		this.propertyAddress = propertyAddressDto;
	}

	public String[] getImageNames() {
		return imageNames;
	}

	public void setImageNames(String[] imageNames) {
		this.imageNames = imageNames;
	}

	public static PropertyDetailsDTO entityToDTO(PropertyDetails p) {
		PropertyDetailsDTO dto = new PropertyDetailsDTO();
		dto.setAreaInSqft(p.getAreaInSqft());
		dto.setNoOfPhotosUploaded(p.getNoOfPhotos());
		String s = p.getFileNames();
		String[] files = s.split(",");
		dto.setImageNames(files);
		dto.setBuildingAge(p.getBuildingAge());
		dto.setBathRooms(p.getBathRooms());
		dto.setBedRooms(p.getBedRooms());
		dto.setDescription(p.getDescription());
		dto.setCategory(p.getCategory());
		dto.setNumberOfRooms(p.getNumberOfRooms());
		dto.setPropertyId(p.getPropertyId());
		dto.setPropertyName(p.getPropertyName());
		dto.setPropertyType(p.getPropertyType());
		dto.setPropertyPrice(p.getPropertyPrice());
		dto.setSellerId(p.getSeller().getSellerId());
		PropertyAddressDTO adto = new PropertyAddressDTO();
		PropertyAddress pa = p.getAddress();
		adto.setAddressId(pa.getAddressId());
		adto.setCity(pa.getCity());
		adto.setAddressLine(pa.getAddressLine());
		adto.setPincode(pa.getPincode());
		adto.setSurveyNo(pa.getSurveyNo());
		adto.setState(pa.getState());
		dto.setPropertyAddress(adto);

		return dto;
	}

	public static PropertyDetails dtoToEntity(PropertyDetailsDTO p) {
		PropertyDetails dto = new PropertyDetails();
		dto.setNoOfPhotos(p.getNoOfPhotosUploaded());
		dto.setAreaInSqft(p.getAreaInSqft());
		dto.setBuildingAge(p.getBuildingAge());
		dto.setNumberOfRooms(p.getNumberOfRooms());
		dto.setBathRooms(p.getBathRooms());
		dto.setBedRooms(p.getBedRooms());
		dto.setCategory(p.getCategory());
		dto.setDescription(p.getDescription());
		String name = "";
		String[] names = p.getImageNames();
		for (String s : names) {
			name = name + s + ",";
		}
		name = name.substring(0, name.length() - 1);
		System.out.println(name);
		dto.setFileNames(name);
		SellerRegistration s = new SellerRegistration();
		s.setSellerId(p.getSellerId());
		dto.setSeller(s);
		dto.setPropertyName(p.getPropertyName());
		dto.setPropertyType(p.getPropertyType());
		dto.setPropertyPrice(p.getPropertyPrice());
		PropertyAddress adto = new PropertyAddress();
		PropertyAddressDTO pa = p.getPropertyAddress();

		adto.setCity(pa.getCity());
		adto.setAddressLine(pa.getAddressLine());
		adto.setPincode(pa.getPincode());
		adto.setSurveyNo(pa.getSurveyNo());
		adto.setState(pa.getState());
		dto.setAddress(adto);

		return dto;
	}

}
