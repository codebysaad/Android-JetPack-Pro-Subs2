package xyz.webflutter.myandroidjetpackpro.utils;

import java.util.ArrayList;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;

public class DummyData {
    public static String baseImageUrl = "https://image.tmdb.org/t/p/w500/";
    public static ArrayList<MovieModels> generateDataMovies(){
        ArrayList<MovieModels> movies = new ArrayList<>();
        movies.add(new MovieModels("1", "Avengers: Infinity War", "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.", "2018-04-27", "bOGkgRGdhrBYJSLpXaxhXVstddV.jpg"));
        movies.add(new MovieModels("2", "It: Chapter Two", "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.", "2019-09-06", "p15fLYp0X04mS8cbHVj7mZ6PBBE.jpg"));
        movies.add(new MovieModels("3", "Dark Phoenix","The X-Men face their most formidable and powerful foe when one of their own, Jean Grey, starts to spiral out of control. During a rescue mission in outer space, Jean is nearly killed when she's hit by a mysterious cosmic force. Once she returns home, this force not only makes her infinitely more powerful, but far more unstable. The X-Men must now band together to save her soul and battle aliens that want to use Grey's new abilities to rule the galaxy.","2019-06-07","cjRUhKyt2Jo3V1KNzc5tpPNfccG.jpg"));
        movies.add(new MovieModels("4", "Spider-Man: Far from Home", "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","2019-07-02","dihW2yTsvQlust7mSuAqJDtqW7k.jpg"));
        movies.add(new MovieModels("5","Avengers: Endgame", "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.", "2019-04-26", "7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg"));
        movies.add(new MovieModels("6","Men in Black: International", "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.", "2019-06-14", "enNSnMYj78ihLmiWrB4K6ymv9ux.jpg"));
        movies.add(new MovieModels("7","Cars", "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.","2006-06-09","a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg"));
        movies.add(new MovieModels("8","Godzilla: King of the Monsters", "Follows the heroic efforts of the crypto-zoological agency Monarch as its members face off against a battery of god-sized monsters, including the mighty Godzilla, who collides with Mothra, Rodan, and his ultimate nemesis, the three-headed King Ghidorah. When these ancient super-species - thought to be mere myths - rise again, they all vie for supremacy, leaving humanity's very existence hanging in the balance.", "2019-05-31", "cNt14e43I2DDW6Xd9zFhrP8eOcA.jpg"));
        movies.add(new MovieModels("9","Aladdin", "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.", "2019-05-24", "v4yVTbbl8dE1UP2dWu5CLyaXOku.jpg"));
        movies.add(new MovieModels("10","Fast & Furious Presents: Hobbs & Shaw", "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.", "2019-08-02", "hpgda6P9GutvdkDX5MUJ92QG9aj.jpg"));
        return movies;
    }
    public static MovieModels getMovies(String courseId){
        for (int i = 0; i < generateDataMovies().size(); i++){
            MovieModels models = generateDataMovies().get(i);
            if (models.getId().equals(courseId)){
                return models;
            }
        }
        return null;
    }
    public static ArrayList<TvShowModels> generateDataTvShow(){
        ArrayList<TvShowModels> tvShowModels = new ArrayList<>();
        tvShowModels.add(new TvShowModels("1", "Arrow", "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.","2012-10-10","dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg"));
        tvShowModels.add(new TvShowModels("2","The Flash", "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.","2014-10-07", "jC1KqsFx8ZyqJyQa2Ohi7xgL7XC.jpg"));
        tvShowModels.add(new TvShowModels("3","Family Guy", "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.","1999-01-31","3OFrs1ets87VmRvG78Zg5eJTZeq.jpg"));
        tvShowModels.add(new TvShowModels("4","Fear the Walking Dead","What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.","2015-08-23","nUXzdD2Jo3wV9Q7mIZjK46Yyty4.jpg"));
        tvShowModels.add(new TvShowModels("5","13 Reasons Why","After a teenage girl's perplexing suicide, a classmate receives a series of tapes that unravel the mystery of her tragic choice.","2017-03-31","sZb21d6EWKAEKZ9GrLQeMwX4cWN.jpg"));
        tvShowModels.add(new TvShowModels("6","Gotham","Before there was Batman, there was GOTHAM. \n\nEveryone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker? ","2014-09-22","mKBP1OCgCG0jw8DwVYlnYqVILtc.jpg"));
        tvShowModels.add(new TvShowModels("7","The Simpsons","Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.","1989-12-17","1pP0gg0iNGX06wSs19EQOvzfZIF.jpg"));
        tvShowModels.add(new TvShowModels("8","Naruto Shippūden","Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.","2007-02-15","c14vjmndzL9tBdooGsMznMFrFLo.jpg"));
        tvShowModels.add(new TvShowModels("9","Kengan Ashura","Since the Edo periods of Japan, gladiator arenas exist in certain areas. In these arenas, wealthy business owners and merchants hire gladiators to fight in unarmed combat where winner takes all. Toki Taouma, nicknamed \"Ashura,\" joins these arenas and devastates his opponents. His spectacular ability to crush his enemies catches the attention of the big business owners, including the Nogi Group chairman, Nogi Hideki.","2019-07-31","mSneKokO9jMNd5QwYHccymERVqj.jpg"));
        tvShowModels.add(new TvShowModels("10","Legion","David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he’s confronted with the possibility that the voices he hears and the visions he sees might be real.","2017-02-08","87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg"));
        return tvShowModels;
    }
    public static TvShowModels getTvShow(String courseId){
        for (int i = 0; i < generateDataTvShow().size(); i++){
            TvShowModels tvModels = generateDataTvShow().get(i);
            if (tvModels.getId().equals(courseId)){
                return tvModels;
            }
        }
        return null;
    }
}
