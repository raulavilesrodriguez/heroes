package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero


@Composable
fun HeroesScreen(
    heroes: List<Hero>,
    contentPadding: PaddingValues,
){
 LazyColumn(contentPadding = contentPadding){
     items(heroes){
         HeroItem(
             hero = it,
             modifier = Modifier.padding(
                 start = dimensionResource(id = R.dimen.padding_medium),
                 top = dimensionResource(id = R.dimen.padding_small),
                 end = dimensionResource(id = R.dimen.padding_medium),
                 bottom = dimensionResource(id = R.dimen.padding_small),
             )
         )
     }
 }
}


@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.elevation_small)),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeroInformation(nameRes = hero.nameRes, descriptionRes = hero.descriptionRes)
            HeroIcon(heroIcon = hero.imageRes)
        }
    }
}

@Composable
fun HeroInformation(
    @StringRes nameRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .width(dimensionResource(id = R.dimen.width_large))
            .padding(end = dimensionResource(id = R.dimen.padding_medium))
            .fillMaxHeight(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(id = nameRes),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(id = descriptionRes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 0.dp)
        )
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.object_size))
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(id = heroIcon),
        contentDescription = null
    )

}