package pojo;

/**
 * brand info
 *
 *  option + click
 *  use boxing type for default value of null
 */
public class Brand {
     // id
    private Integer id;

    // brand_name
    private String brandName;

    // company name
    private String companyName;

    // order
    private Integer ordered;

    // description
    private String description;

    // status 0/1
    // Integer boxing default = null
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", order=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
