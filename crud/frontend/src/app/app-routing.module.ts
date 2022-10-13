import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductCreateComponent } from './components/product/product-create/product-create.component';
import { HomeComponent } from "./views/home/home.component";
import { ProductCrudComponent } from "./views/product-crud/product-crud.component";
import {ProductUpdateComponent} from "./components/product/product-update/product-update.component";
import { ProductLogComponent } from './components/product/product-log/product-log.component';


const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "products",
    component: ProductCrudComponent
  },
  {
    path:"products/create",
    component:ProductCreateComponent
  },
  {
    path:"products/update/:id",
    component:ProductUpdateComponent
  },
  {
    path:"products/log/:id",
    component:ProductLogComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
