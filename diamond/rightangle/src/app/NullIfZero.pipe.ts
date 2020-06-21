import { Pipe, PipeTransform } from '@angular/core';
// https://www.freakyjolly.com/angular-6-7-create-custom-pipes-aka-filters-in-angular-
@Pipe({
    name: 'NullIfZero'
})

export class NullIfZero implements PipeTransform {
    transform(value: number): number {
        return value === 0.0 ? null : value;
    }
}
