package com.xh.translate.utils

import com.xh.translate.PageConfig
import com.xh.translate.bean.FileType
import com.xh.translate.bean.Page
import com.xh.translate.bean.XmlPair
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
        val pageList = mutableMapOf<String, Page>();

        //重复字段列表
        val duplicateMap = mutableMapOf<String, Map<String, List<List<XmlPair>>>>()

        for (path in srcPath) {
            pageList[path] = createParse(path).read(path, config).apply {
                val map = getAllDuplicatePairIgnoreSpecCh(config)
                if (map != null) {
                    duplicateMap[path] = map
                }
            }
        }

        //冲突字段列表
        val configList = PageUtils.getConflict(pageList)
        val totalPage = PageUtils.merge(pageList.values.toList())

        createParse(desPath).write(desPath, totalPage, config)
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

    interface ConvertResultCallback{
        fun onSuccess(desPath: String, srcPath: List<String>)
        fun onFail(duplicateMap: Map<String, Map<String, List<List<XmlPair>>>>, configList:)
    }
}