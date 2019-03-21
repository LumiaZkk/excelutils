package cn.fay.excel.annotations;

import cn.fay.excel.handle.DefaultExcelExportFileNameSuffixGenerate;
import cn.fay.excel.handle.ExcelExportFileNameSuffixGenerate;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不能被继承，只读取本类
 * 设置导出excel的文件名sheet名等
 *
 * @author fay  fay9395@gmail.com
 * @date 2019-03-21 16:24.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelExportInfo {
    /**
     * http 下载时使用
     */
    String fileNamePrefix();

    String sheetName() default "Sheet1";

    String fileNameSuffixGenerateClassName() default "cn.fay.excel.handle.DefaultExcelExportFileNameSuffixGenerate";

    Class<? extends ExcelExportFileNameSuffixGenerate> fileNameSuffixGenerateClass() default DefaultExcelExportFileNameSuffixGenerate.class;

    /**
     * 默认列名单元格格式
     * {@link ExcelExportField#columnNameCellStyle()} 中相应方法值会覆盖该值
     */
    CellStyle defaultColumnNameCellStyle() default @CellStyle(
            font = @Font(boldweight = HSSFFont.BOLDWEIGHT_BOLD),
            alignment = HSSFCellStyle.ALIGN_LEFT);

    /**
     * 默认列值单元格格式
     * {@link ExcelExportField#columnValueCellStyle()} ()} 中相应方法值会覆盖该值
     */
    CellStyle defaultColumnValueCellStyle() default @CellStyle (alignment = HSSFCellStyle.ALIGN_LEFT);

    /**
     * 默认最后一列值单元格格式
     * {@link ExcelExportField#lastRowCellStyle()} ()} ()} 中相应方法值会覆盖该值
     */
    CellStyle defaultLastRowCellStyle() default @CellStyle (alignment = HSSFCellStyle.ALIGN_LEFT);
}

