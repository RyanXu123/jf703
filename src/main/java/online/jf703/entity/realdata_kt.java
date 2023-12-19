package online.jf703.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class realdata_kt {
    @TableId
    private String location;
    private String equipment;
    private double acPower;
   private double operateState;
    private double errorState;
    private double sfSet;
    private double hfSet;
    private double ysj1;
    private double ysj2;
    private double fj1;
    private double fj2;
    private double lnfj1;
    private double lnfj2;
    private double hfT1;
    private double hfT2;
    private double hfT3;
    private double hfT4;
    private double sfT1;
    private double sfT2;
}
