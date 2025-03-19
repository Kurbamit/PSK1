package lt.vu.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Owner {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.OWNER.ID
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.OWNER.FULL_NAME
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    private String fullName;

    private List<Car> cars;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.OWNER.ID
     *
     * @return the value of PUBLIC.OWNER.ID
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.OWNER.ID
     *
     * @param id the value for PUBLIC.OWNER.ID
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.OWNER.FULL_NAME
     *
     * @return the value of PUBLIC.OWNER.FULL_NAME
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.OWNER.FULL_NAME
     *
     * @param fullName the value for PUBLIC.OWNER.FULL_NAME
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}