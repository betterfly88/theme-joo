package com.themejoo.domain.sheets;

import com.google.api.services.sheets.v4.model.ValueRange;
import com.themejoo.domain.stockinfo.StockInfo;
import com.themejoo.domain.stockinfo.StockInfoRepositoryImpl;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.11
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api")
//@Api(value = "v1/sheet", description = "sheet api")
public class SheetController {
    private SheetServiceImpl sheetMaker;

    @Autowired
    private StockInfoRepositoryImpl stockInfoService;

    @GetMapping("/sheet")
    public void getSheet(){
        try{
//            ValueRange list = sheetMaker.readSheets("A1:L79");
//            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/make/sheet")
    public void getMakeSheet(){
        try{
            sheetMaker.makeSpreadSheet("시트만들기");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PostMapping("/stockinfo")
    public List<StockInfo> getStockListDetail(
            @RequestBody StockInfo stockInfo){

        return stockInfoService.findByStockInfoQueryAdvance(stockInfo.getStockCode(), stockInfo.getCompany());
    }
}
