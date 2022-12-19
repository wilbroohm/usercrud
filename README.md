# Person Add/List

### Part 1

1) Retourner tous les éléments book
   

        <book>
           <title>toto1</title>
           <author>titi</author>
        </book>
        <book type="doc">
           <title>toto2</title>
           <author>titi</author>
        </book>
        <book type="roman">
           <title>toto3</title>
           <author>titi</author>
        </book>
        <book type="bd">
           <title>toto4</title>
           <author>titi2</author>
        </book>
        <book type="roman">
            <title>toto5</title>
            <author>titi</author>
        </book>


2) Retourner tous les éléments title ayant comme parent un élément book avec un attribut type égal à roman

        <book type="roman">
             <title>toto5</title>
             <author>titi</author>
        </book>

3) Retourner le nombre d'éléments book ayant un attribut type égal à bd

        <title>toto4</title>
        <author>titi2</author>

4) Que renvoie la requête XPath suivante :  /library/library/ancestor-or-self::library

        <book type="roman">
			<title>toto5</title>
			<author>titi</author>
		</book>

### Part 2
Could not configure the documentation yet
