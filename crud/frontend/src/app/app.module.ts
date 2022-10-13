import { NgModule, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';


import { MatSidenavModule }from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule }from '@angular/material/form-field'
import { MatInputModule }from '@angular/material/input';
import { MatTableModule } from '@angular/material/table'
import { MatGridListModule } from '@angular/material/grid-list'
import { MatPaginatorModule } from '@angular/material/paginator'
import {MatSortModule} from '@angular/material/sort'

import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';
import { HomeComponent } from './views/home/home.component';
import { ProductCrudComponent } from './views/product-crud/product-crud.component';
import { RedDirective } from './directives/red.directive';
import { HttpClientModule } from '@angular/common/http';
import { ProductCreateComponent } from './components/product/product-create/product-create.component'
import { FormsModule }from '@angular/forms'
import { ProductReadComponent } from './components/product/product-read/product-read.component'

import localePt from'@angular/common/locales/pt'
import { registerLocaleData } from '@angular/common';
import { ProductUpdateComponent } from './components/product/product-update/product-update.component';
import { ProductLogComponent } from './components/product/product-log/product-log.component';
import { LocalDateTimePipe } from './shared/pipe/local-date-time.pipe';
registerLocaleData(localePt)

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    ProductCrudComponent,
    RedDirective,
    ProductCreateComponent,
    ProductReadComponent,
    ProductUpdateComponent,
    ProductLogComponent,
    LocalDateTimePipe
  ],
  imports: [
  MatToolbarModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule,
    MatListModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatGridListModule,
    MatPaginatorModule,
    MatSortModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule 
    
  ],
  providers: [{provide:LOCALE_ID,
  useValue: 'pt-br'}, LocalDateTimePipe
    

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
