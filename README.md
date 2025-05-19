[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19397585)
# Unit Deliverable<br><sup>Starter Project<sup>

# JAVA CARD GAME
In this program based off of the game [Balatro](https://www.playbalatro.com/), the player selects and plays hands of cards in an attempt to beat the target score and win the game.

## How to play
![Image of the game](https://cdn.discordapp.com/attachments/1240802108098482199/1374158873304240149/image.png?ex=682d08ae&is=682bb72e&hm=02e1fd30220394f88f255adcbfaa6185aaffb0d72acc5684fa810c1ceb232b10&)

The game consists of 5 levels, each with an increasingly difficult target score to beat. To start, the player enters numbers 1 through 7 to select a card in their hand. They select a maximum of 5 cards, and can choose to either play the hand or discard it. 
When a hand is played, the program detects if it forms one of the following *hands*:
| Hand | Description |
| ----------- | ----------- |
| Straight | 5 cards in increasing order |
| Flush | 5 cards of the same suit |
| Straight Flush | 5 Cards of the same suit and increasing order |
| 2 of a kind | Two cards of the same rank |
| 3 of a kind | Three cards of the same rank |
| 4 of a kind | Four cards of the same rank |
| Two pair | Two pairs of cards of the same rank |
| Full house | A three of a kind and two of a kind | 
| High card | Scores the highest card |
