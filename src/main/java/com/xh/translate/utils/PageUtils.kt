package com.xh.translate.utils

import com.xh.translate.bean.Page
import com.xh.translate.bean.Word

class PageUtils {

    companion object{
        fun merge(list: List<Page>): Page{
            return Page()
        }


        fun getConflict(list: List<Page>): List<List<Word>>{
            //unimplement
        }
    }

}