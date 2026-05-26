package main.java.ch12_stream.advanced.movie_analysis;

import java.util.*;

public class MovieAnalysis {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("인셉션", "SF", 2010, 8.8),
                new Movie("어벤져스", "액션", 2012, 8.0),
                new Movie("기생충", "드라마", 2019, 8.6),
                new Movie("매트릭스", "SF", 1999, 8.7),
                new Movie("인터스텔라", "SF", 2014, 8.6),
                new Movie("다크나이트", "액션", 2008, 9.0),
                new Movie("어바웃타임", "로맨스", 2013, 8.3),
                new Movie("라라랜드", "뮤지컬", 2016, 8.1)
        );

        // 1. 장르가 "SF"인 영화의 평균 평점 구하기
        // 결과 : 약 8.7

        double sfRating = movies.stream()
                            .filter(movie -> movie.getGenre().equals("SF"))
                            .mapToDouble(movie -> movie.getRating())
                            .average()
                            .getAsDouble();
        System.out.printf("장르가 SF인 영화 평균 평점 : %.2f\n", sfRating);

        // 2. 2010년 이후 개봉된 영화를 평점 내림차순으로 정렬하여 제목 리스트를 반환하기
        // 결과 : [인셉션, 기생충, 인터스텔라, 어바웃타임, 라라랜드, 어벤져스]

        List<String> list = movies.stream()
                .filter(movie -> movie.getReleaseYear() >= 2010)
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .map(Movie::getTitle).toList();

        System.out.println(list);

        // 3. 가장 최근에 개봉된 영화 3개의 제목을 반환하기
        //  결과 : [기생충, 라라랜드, 인터스텔라]

        List<String> list2 = movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
                .limit(3)
                .map(Movie::getTitle)
                .toList();

        System.out.println(list2);

        // 4. 각 장르별로 영화를 그룹화하고, 장르별 영화 수를 맵으로 반환하기
        // 결과 : {SF=3, 액션=2, 드라마=1, 로맨스=1, 뮤지컬=1}



        // 5. 평점이 8.5 이상인 영화들의 장르를 중복 없이 알파벳 순으로 정렬하여 반환하기
        // 결과 : [SF, 드라마, 액션]

        List<String> list3 = movies.stream()
                .filter(movie -> movie.getRating() >= 8.5)
                .map(Movie::getGenre)
                .sorted()
                .distinct()
                .toList();
    }
}
