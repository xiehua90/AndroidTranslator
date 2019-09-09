package com.xh.translate.utils

import com.xh.translate.PageConfig
import com.xh.translate.bean.FileType
import com.xh.translate.bean.Page
import com.xh.translate.parse.ExcelParse
import com.xh.translate.parse.Parse
import com.xh.translate.parse.TxtParse
import com.xh.translate.parse.XmlParse

/**
 * Created by 谢荣华 on 2019.09.04
 *
 *
 * */
class TranslateModel {

    fun convert(desPath: String, srcPath: List<String>, config: PageConfig?) {
        val pageList = mutableListOf<Page>()

        for (path in srcPath){
            pageList.add(createParse(path).read(path, config))
        }
        var list = mutableListOf<Page>()
        var page = Page()
        var page2 = Page()
        PageUtils.merge();



    }



    private fun createParse(filePath: String): Parse {
        val fileType = FileType.newInstance(filePath)
        if (fileType == FileType.UNKNOWN) {
            throw RuntimeException("File type Error:$filePath")
        }

        return when (fileType) {
            FileType.DIR -> XmlParse()
            FileType.EXCEL -> ExcelParse()
            else -> TxtParse()
        }
    }


}