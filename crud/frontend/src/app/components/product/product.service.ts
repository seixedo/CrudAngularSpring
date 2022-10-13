import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar'
import { HttpClient }from "@angular/common/http"
import { Product } from './product-model';
import { Observable, ObservedValueOf } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
baseUrl="http://localhost:8080/produtos"
//baseUrl="http://localhost:3001/products"
  constructor(private router:Router,
    private snack:MatSnackBar,
    private http:HttpClient) { }

  BackHomePage(rota:string): void{
    this.router.navigate(['/'+rota])
  }
  Popup(Mensagem:string):void{
    this.snack.open(Mensagem,"X",{duration:3000,horizontalPosition:"center",verticalPosition:"top"})
  }

  create(product:Product): Observable<Product>{
    console.log(product.alterado);
    console.log(product.inserido);
    return this.http.post<Product>(this.baseUrl,product)

  }
  read():Observable<Product[]>{
    return this.http.get<Product[]>(this.baseUrl)
  }
  getById(id:String):Observable<Product>{
    const url =`${this.baseUrl}/${id}`
    return this.http.get<Product>(url)
  }

  update(product:Product):Observable<Product>{
    const url =`${this.baseUrl}/${product.id}`
    return this.http.put<Product>(url,product)
  }
  }

