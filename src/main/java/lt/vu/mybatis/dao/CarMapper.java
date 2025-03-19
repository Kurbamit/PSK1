package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Car;
import org.mybatis.cdi.Mapper;

@Mapper
public interface CarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    int insert(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    Car selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    List<Car> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CAR
     *
     * @mbg.generated Sat Mar 08 13:33:14 EEST 2025
     */
    int updateByPrimaryKey(Car record);
}