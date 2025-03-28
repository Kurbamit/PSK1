package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.CarPriceGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateCarPriceNumber implements Serializable {
    @Inject
    CarPriceGenerator carPriceGenerator;

    private CompletableFuture<Integer> carPriceGenerationTask = null;

    @LoggedInvocation
    public String generateNewCarPrice() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        carPriceGenerationTask = CompletableFuture.supplyAsync(() -> carPriceGenerator.generateCarPrice());

        return  "/parts.xhtml?faces-redirect=true&carId=" + requestParameters.get("carId");
    }

    public boolean isCarPriceGenerationRunning() {
        return carPriceGenerationTask != null && !carPriceGenerationTask.isDone();
    }

    public String getCarPriceGenerationStatus() throws ExecutionException, InterruptedException {
        if (carPriceGenerationTask == null) {
            return null;
        } else if (isCarPriceGenerationRunning()) {
            return "Car generation in progress";
        }
        return "Suggested car price: " + carPriceGenerationTask.get();
    }
}