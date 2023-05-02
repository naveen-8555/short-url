import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShortUrlService {
  serviceUrl: string = '';

  constructor(private http: HttpClient) {
    this.serviceUrl = "http://localhost:8080/url/shortner";
  }

  getShortUrl(url: string) {
    return this.http.post<any>(this.serviceUrl, url);
  }

}
