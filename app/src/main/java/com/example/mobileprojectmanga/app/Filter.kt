package com.example.mobileprojectmanga.app

import com.example.mobileprojectmanga.data.MangaCard

class Filter {
    var title: String? = null
    var artists: String? = null
    var writers: String? = null
    var genres: String?= null
    var publisher: String?= null

    fun checkFilter(manga: MangaCard): Boolean{
        var isInFilteredElement: Boolean = true
        if (title!=null && manga.title!=title){
            isInFilteredElement=false;
        }
        if (artists!=null && manga.artists!=artists){
            isInFilteredElement=false;
        }
        if (writers!=null && manga.writers!=writers){
            isInFilteredElement=false;
        }
        if (genres!=null && manga.genres!=genres){
            isInFilteredElement=false;
        }
        if (publisher!=null && manga.publisher!=publisher){
            isInFilteredElement=false;
        }
        return isInFilteredElement;
    }
}