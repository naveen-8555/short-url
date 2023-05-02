import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SearchComponent} from "./search/search.component";
import {GenerateComponent} from "./generate/generate.component";

const routes: Routes = [
  {
    path: 'generate',
    component: GenerateComponent
  },
  {
    path: 'search',
    component: SearchComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
