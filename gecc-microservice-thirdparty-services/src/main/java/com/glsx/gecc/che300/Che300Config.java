package com.glsx.gecc.che300;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//@ConfigurationProperties(prefix = "che300")
public class Che300Config {

    @Value("${che300.getallcity.url}")
    private String allCityUrl;

    @Value("${che300.common.eval.url}")
    private String commonEvalUrl;

    @Value("${che300.getcarbrandlist.url}")
    private String carBrandListUrl;

    @Value("${che300.getcarserieslist.url}")
    private String carSeriesListUrl;

    @Value("${che300.getcarmodellist.url}")
    private String carModelListUrl;

    @Value("${che300.getseriesinfo.url}")
    private String seriesInfoUrl;

    @Value("${che300.getcarmodelinfo.url}")
    private String carModelInfoUrl;

    @Value("${che300.getmodelparameters.url}")
    private String modelParametersUrl;

    @Value("${che300.getupdatedmodelparamsintimerange.url}")
    private String updatedModelParamsInTimeRangeUrl;

    @Value("${che300.getusedcarprice.url}")
    private String usedCarPriceUrl;

    @Value("${che300.token}")
    private String token;

}
