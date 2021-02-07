import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { People } from '../model/people';
import {Observable} from 'rxjs/Rx';


@Injectable()
export class PeopleService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/v1/people';
  }

  public findAll(): Observable<People[]> {
    return Observable.interval(5000).flatMap(() => {
      return this.http.get<People[]>(this.usersUrl);
    });
  }

  public save(user: People) {
    return this.http.post<People>(this.usersUrl, user);
  }
}
