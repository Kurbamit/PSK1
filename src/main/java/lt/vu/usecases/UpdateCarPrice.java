package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.CarsDAO;
import lt.vu.entities.Car;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateCarPrice implements Serializable {

    private Car car;

    @Inject
    private CarsDAO carsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateCarPrice INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer carId = Integer.parseInt(requestParameters.get("carId"));
        this.car = carsDAO.findOne(carId);
    }

    @Transactional
    @LoggedInvocation
    public String updateCarPrice() {
        try{
            carsDAO.update(this.car);
        } catch (OptimisticLockException e) {
            return "/parts.xhtml?faces-redirect=true&carId=" + this.car.getId() + "&error=optimistic-lock-exception";
        }
        return "cars.xhtml?ownerId=" + this.car.getOwner().getId() + "&faces-redirect=true";
    }
}