package task_16;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrganizationTemplate {
    String id;
    String name;
    String displayName;
    String desc;
    Object descData;
    String url;
    String website;
    String teamType;
    String logoHash;
    String logoUrl;
    String offering;
    Object products;
    Object powerUps;
    String idMemberCreator;
    Object limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getDescData() {
        return descData;
    }

    public void setDescData(Object descData) {
        this.descData = descData;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getLogoHash() {
        return logoHash;
    }

    public void setLogoHash(String logoHash) {
        this.logoHash = logoHash;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getOffering() {
        return offering;
    }

    public void setOffering(String offering) {
        this.offering = offering;
    }

    public Object getProducts() {
        return products;
    }

    public void setProducts(Object products) {
        this.products = products;
    }

    public Object getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(Object powerUps) {
        this.powerUps = powerUps;
    }

    public String getIdMemberCreator() {
        return idMemberCreator;
    }

    public void setIdMemberCreator(String idMemberCreator) {
        this.idMemberCreator = idMemberCreator;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        return "OrganizationTemplate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", desc='" + desc + '\'' +
                ", descData=" + descData +
                ", url='" + url + '\'' +
                ", website='" + website + '\'' +
                ", teamType='" + teamType + '\'' +
                ", logoHash='" + logoHash + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", offering='" + offering + '\'' +
                ", products=" + products +
                ", powerUps=" + powerUps +
                ", idMemberCreator='" + idMemberCreator + '\'' +
                ", limits=" + limits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationTemplate that = (OrganizationTemplate) o;
        return Objects.equals(displayName, that.displayName) && Objects.equals(offering, that.offering) && Objects.equals(idMemberCreator, that.idMemberCreator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, offering, idMemberCreator);
    }
}







