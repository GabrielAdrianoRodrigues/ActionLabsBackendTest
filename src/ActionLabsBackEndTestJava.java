/**
 * Resolução para os desafios desenvolvidos pela Action Labs para a vaga de BackEnd Java
 * 
 * Resolvi n&atildeo utilizar imports para poder injetar em qualquer classe sem problemas 
 * @Author Gabriel Adriano Rodrigues
 */
public class ActionLabsBackEndTestJava {
    /*
        Write a program that prints the numbers from 1 to 100.
        But for multiples of three print "Fizz" instead of the number 
        and for multiples of five print "Buzz". For numbers which are 
        multiples of both three and five print "FizzBuzz".
        Method signature: void printFizzBuzz(); 
    */
    void printFizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i % 3 == 0 && i % 5 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : i);
        }
    }

    /*
        Before Marvin, the Paranoid Android, became so bored and depressed by humanity, 
        he was a musician in the Sirius Cibernetic Corporation. One day, he decided to 
        discover the rare notes in every song ever produced. A rare note is a note that 
        appears only once in a particular song. As Marvin has a head the size of a planet, 
        he knows that it will will take just a nanosecond to process all the songs, 
        but the diodes in his left side are in such a pain he don't want to write a 
        program that can solve this and he is waiting for you to do it. Given an int[] "notes" 
        with all the notes in a song, return another int[] with the rare notes present in that song. 
        For example, given a song with the notes {1, 2, 3, 2, 2, 1, 5, 5}, your method should
        return {3}. If there are no rare notes in the song, your method should return null.
        Method signature: int[] getRareNotes(int[] notes)
        */
    int[] getRareNotes(int[] notes) {
        int[] rareNotes = java.util.Arrays.stream(notes).filter(e -> java.util.Collections.frequency(java.util.Arrays.stream(notes).boxed().collect(java.util.stream.Collectors.toList()), e) == 1).toArray();
        return rareNotes.length == 0 ? null : rareNotes;
    }
    
    /*
        When Hodor was a teenager, he became interested in door strengths. He knew how 
        strong he was and was always trying to figure out how long he could keep a door 
        closed with an horde of zombies behind it trying to pass through. By his calculations,
        he was able to hold "hodorStrength" zombies. Given a "doorsStrength" array with N doors
        and the amount of zombies each door can hold by itself and a "zombieInflux" array with
        the number of zombies arriving at each door per second, return the door that Hodor can
        hold the longest before being crushed. You are guaranteed that both arrays have the same
        length. For example, for an input where hodorStrength=50, doorsStrength={10,25,5} and 
        zombiesInflux={2,3,1}, door[0] would be held for 30 seconds, door[1] would be held for 
        25 seconds and door[2] would be held for 55 seconds. So the answer in this case is "2".
        Method signature: int holdTheDoor(int hodorStrength, int[] doorsStrength, int[] zombiesInflux) 
    */
    int holdTheDoor(int hodorStrength, int[] doorsStrength, int[] zombiesInflux) {
        return java.util.Collections.max(java.util.stream.IntStream.range(0, doorsStrength.length).boxed().collect(java.util.stream.Collectors.toMap(i -> i, i -> (hodorStrength + doorsStrength[i]) / zombiesInflux[i])).entrySet(), java.util.Map.Entry.comparingByValue()).getKey();
    }

    /*
        Since Kylo Ren discovered that his name was an anagram for Ken Rylo
        (which was the family's dog), he became obsessed with anagrams. 
        As he was not the smartest kid around, he asked for one renowned 
        Sith programmer (you!) to write some code that could check if two 
        words were anagrams.Two words are considered anagrams if they consist
        of the same characters, even if in a different order. So "ACT" is
        an anagram for "CAT" and for "ACT" itself, but not for "TACT".Your
        method should be case insensitive and must ignore whitespaces ("Kylo 
        Ren" and "KN Lore Y" should be considered anagrams).
        Method signature: boolean areAnagrams(String word1, String word2) 
    */
    boolean areAnagrams(String word1, String word2) {
        char[] w1 = word1.toUpperCase().replace(" ", "").toCharArray();
        char[] w2 = word2.toUpperCase().replace(" ", "").toCharArray();
        java.util.Arrays.sort(w1);
        java.util.Arrays.sort(w2);
        return java.util.Arrays.equals(w1, w2);
    }
}
